package com.lyd.newsstory.bean;

import java.util.List;

public class MeiNvGson {
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2019-09-17 14:00","title":"小清新吊带美女[9P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/1/8b/0f864d2b75_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010946-0-1.html"},{"ctime":"2019-09-16 21:00","title":"清纯制服校花美女[8P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/8/48/64e0e4e247_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010310-0-1.html"},{"ctime":"2019-09-16 21:00","title":"女孩白色短裤养眼长发神秘的清新感[14P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/f/69/cbcb46abf7_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010316-0-1.html"},{"ctime":"2019-09-16 21:00","title":"美女蓝色运动服性感美腿[9P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/0/bd/87356ac1fb_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010326-0-1.html"},{"ctime":"2019-09-16 19:01","title":"极品学生妹美女模特海军制服[9P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/2/7d/54e517f512_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010274-0-1.html"},{"ctime":"2019-09-16 19:01","title":"美女清纯气质短发[16P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/6/4d/51d91c5d16_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010282-0-1.html"},{"ctime":"2019-09-16 19:01","title":"清纯校花校园操场可爱[13P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/f/2e/1e66604dc5_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010297-0-1.html"},{"ctime":"2019-09-16 19:01","title":"梦幻长发飘飘校花美女[12P]","description":"华声美女","picUrl":"http://img.mm4000.com/file/c/96/a6dc322176_1044.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9010307-0-1.html"},{"ctime":"2019-09-16 13:01","title":"90后萌妹子MM夏日清纯可爱[14P]","description":"华声美女","picUrl":"https://img.99ym.cn/uploads/tu/20150918/24529-1RWEIc.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9009764-0-1.html"},{"ctime":"2019-09-16 13:01","title":"空姐制服迷人写真[17P]","description":"华声美女","picUrl":"https://pic.99ym.cn/uploads/tu/201502/072/1.jpg","url":"http://bbs.voc.com.cn/mm/meinv-9009781-0-1.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2019-09-17 14:00
         * title : 小清新吊带美女[9P]
         * description : 华声美女
         * picUrl : http://img.mm4000.com/file/1/8b/0f864d2b75_1044.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-9010946-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"刘雨欣美女桌面","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_2411c2dfab27e4411a27c16f4f87dd22-760x500.jpg","url":"http://m.xxxiao.com/1811"},{"ctime":"2016-03-06 14:11","title":"Beautyleg &#8211; Arvi 私房美腿写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/05/m.xxxiao.com_e7e731faf790487ccaf90d11774fae6b-760x500.jpg","url":"http://m.xxxiao.com/1353"},{"ctime":"2016-03-06 14:11","title":"美女泷泽萝拉性感壁纸图片","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_7b09f0aa22aff3b6cfbad8ceb9abecbb-760x500.jpg","url":"http://m.xxxiao.com/2099"},{"ctime":"2016-03-06 14:11","title":"美少女韩雨嘉可爱私拍","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_1c3cc572a80ccc3343062e7ad6c51180-760x500.jpg","url":"http://m.xxxiao.com/2010"},{"ctime":"2016-03-06 14:11","title":"篱笆墙后的巨乳美女杉原杏璃","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_3517d593632d19b77032faaeef2fbf68-760x500.jpg","url":"http://m.xxxiao.com/1908"},{"ctime":"2016-03-06 14:11","title":"[TGOD推女神] 性感少妇Aline艾琳私房写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_26da7f08a6170deda90a8bcd208618f9-760x500.jpg","url":"http://m.xxxiao.com/249"},{"ctime":"2016-03-06 14:11","title":"性感女神绮里嘉爆乳浴室裸体玫瑰","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_252e691406782824eec43d7eadc3d2568-760x500.jpg","url":"http://m.xxxiao.com/521"},{"ctime":"2016-03-06 14:11","title":"[TGOD推女神] 泳池美人虞 75F乳神于姬Una私房泳装","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_3e6ffd8abf2d3fbd1040b02edb6bcb66-760x500.jpg","url":"http://m.xxxiao.com/370"},{"ctime":"2016-03-06 14:11","title":"AISS爱丝美女 丝袜美腿\u2026小哲女神","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_be45c01a6ad655cf09937e579c486526-760x500.jpg","url":"http://m.xxxiao.com/971"},{"ctime":"2016-03-06 14:11","title":"瑰姿艳逸蕾丝连体衣浴室惊艳欲照","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_596a3d04481816330f07e4f97510c28f9-760x500.jpg","url":"http://m.xxxiao.com/451"}]
     */

   /* private int code;
    private String msg;
    *//**
     * ctime : 2016-03-06 14:11
     * title : 刘雨欣美女桌面
     * description : 美女图片
     * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_2411c2dfab27e4411a27c16f4f87dd22-760x500.jpg
     * url : http://m.xxxiao.com/1811
     *//*

    private List<NewslistBean> newslist;

    public static MeiNvGson objectFromData(String str) {

        return new Gson().fromJson(str, MeiNvGson.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public static NewslistBean objectFromData(String str) {

            return new Gson().fromJson(str, NewslistBean.class);
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }*/

}
