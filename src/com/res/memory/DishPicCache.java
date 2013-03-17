package com.res.memory;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.util.LruCache;
import com.res.view.R;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * 图片缓存
 * </p>
 * User: LICHEN
 * Date: 13-2-24
 * Time: 下午12:59
 * version: v1.0
 * since: v1.0
 */
public final class DishPicCache {
    private static DishPicCache dishPicCache = new DishPicCache();

    private static final int SOFT_CACHE_CAPACITY = 40;

    private static final int HARD_CACHE_SIZE = 8 * 1024 * 1024;

    private static final LinkedHashMap<String, SoftReference<Bitmap>> softBitmapCache =
            new LinkedHashMap<String, SoftReference<Bitmap>>(SOFT_CACHE_CAPACITY, 0.75f, true) {
                @Override
                public SoftReference<Bitmap> put(String key, SoftReference<Bitmap> value) {
                    return super.put(key, value);
                }

                @Override
                protected boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> eldest) {
                    return size() > SOFT_CACHE_CAPACITY;
                }
            };

    private final LruCache<String, Bitmap> hardBitmapCache = new LruCache<String, Bitmap>(HARD_CACHE_SIZE) {
        @Override
        public int sizeOf(String key, Bitmap value) {
            return value.getRowBytes() * value.getHeight();
        }

        @Override
        protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
            Log.v("tag", "hard cache is full,push to soft cache");
            softBitmapCache.put(key, new SoftReference<Bitmap>(oldValue));
        }
    };

    private static Context context;

    private static File cacheDir;

    //todo 联网之后不需要初始化缓存
    static int[] dishReses =
            {R.drawable.tankaoxueyu, R.drawable.shengjianqiudaoyu, R.drawable.xianggudunji,
                    R.drawable.tangcuixiaren, R.drawable.sijishishu, R.drawable.qingchaolusun, R.drawable.liuliansu,
                    R.drawable.ningmengdangao, R.drawable.chivas, R.drawable.taozui, R.drawable.niuroumian,
                    R.drawable.congyoubing};
    static String[] resourceNames =
            {"tankaoxueyu.jpg", "shengjianqiudaoyu.jpg", "xianggudunji.jpg", "tangcuixiaren.jpg", "sijishishu.jpg",
                    "qingchaolusun.jpg",
                    "liuliansu.jpg", "ningmengdangao.jpg",
                    "chivas.jpg", "taozui.jpg", "niuroumian.jpg", "congyoubing.jpg"};

    private DishPicCache() {

    }

    public static DishPicCache getInstance(Context context) {
        DishPicCache.context = context;
        cacheDir = context.getCacheDir();
        Resources resources = context.getResources();
        InputStream is;
        for (int i = 0; i < dishReses.length; i++) {
            is = resources.openRawResource(dishReses[i]);
            Bitmap bitmap = new BitmapDrawable(resources, is).getBitmap();
            dishPicCache.putToFile(resourceNames[i], bitmap);
        }
        return dishPicCache;
    }

    public boolean put(String key, Bitmap pic) {
        if (pic != null) {
            synchronized (hardBitmapCache) {
                hardBitmapCache.put(key, pic);
            }
        }
        return false;
    }

    public int getPicRes(String key) {
        for (int i = 0; i < resourceNames.length; i++) {
            if (resourceNames[i].equals(key)) {
                return dishReses[i];
            }
        }
        return -1;
    }

    public Bitmap get(String key) {
        synchronized (hardBitmapCache) {
            final Bitmap bitmap = hardBitmapCache.get(key);
            if (bitmap != null) {
                return bitmap;
            }
        }

        synchronized (softBitmapCache) {
            SoftReference<Bitmap> bitmapSoftReference = softBitmapCache.get(key);
            if (bitmapSoftReference != null) {
                final Bitmap bitmap2 = bitmapSoftReference.get();
                if (bitmap2 != null) {
                    return bitmap2;
                } else {
                    Log.v("tag", "soft reference has been recycled");
                    softBitmapCache.remove(key);
                }
            }
        }

        Bitmap bitmap3 = getFromFile(key);
        if (bitmap3 != null) {
            return bitmap3;
        } else {
            //TODO 从网上下载图片
        }

        return null;
    }

    private static final int MAX_FILE_CACHE_SIZE = 20 * 1024 * 1024;

    private final LruCache<String, Long> fileCache = new LruCache<String, Long>(MAX_FILE_CACHE_SIZE) {
        @Override
        protected int sizeOf(String key, Long value) {
            return value.intValue();
        }

        @Override
        protected void entryRemoved(boolean evicted, String key, Long oldValue, Long newValue) {
            File file = null;
            file = getFile(key);
            if (file != null) {
                file.delete();
            }
        }
    };

    private File getFile(String filename) {
        File file = new File(cacheDir, filename);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return file;
    }

    public boolean putToFile(String key, Bitmap bitmap) {
        boolean saved = false;
        try {
            hardBitmapCache.put(key, bitmap);
            File file = getFile(key);
            if (file != null) {
                Log.v("tag", "file already exists");
                fileCache.put(key, file.length());
                return true;
            }

            FileOutputStream fos = getOutputStream(key);
            saved = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();

            if (saved) {
                synchronized (fileCache) {
                    fileCache.put(key, getFile(key).length());
                }
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static BitmapFactory.Options bitmapOptions;

    static {
        bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inPurgeable = true;
    }

    public Bitmap getFromFile(String key) {
        File bitmapFile = null;
        try {
            bitmapFile = getFile(key);
            if (bitmapFile != null) {
                Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(bitmapFile), null, bitmapOptions);
                if (bitmap != null) {
                    hardBitmapCache.put(key, bitmap);
                    return bitmap;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private FileOutputStream getOutputStream(String key) throws FileNotFoundException {
        if (cacheDir == null) {
            return null;
        }
        return new FileOutputStream(cacheDir.getAbsolutePath() + File.separator + key);
    }

}
