package jgq.com.zhong;

import java.util.List;

public class Bean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-04-23 11:00","title":"老上海风情","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/23/07/20180423075206181-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8332060-0-1.html"},{"ctime":"2018-04-23 16:00","title":"I邻家女孩\u2026\u2026[无序排列 罗佩恩 114p]\u2026\u2026第1110辑","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/21/20/201804212035208281-1559530.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8330834-0-1.html"},{"ctime":"2018-04-24 10:00","title":"衣模","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/24/09/201804240919072211-3030167.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8334463-0-1.html"},{"ctime":"2018-04-24 12:00","title":"清新甜美氧气美女肌肤白嫩酥胸美腿私房写真","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/23/18/201804231827029341-2053485.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8333580-0-1.html"},{"ctime":"2018-04-24 12:00","title":"葵林倩影","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/24/06/201804240629131861-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8334223-0-1.html"},{"ctime":"2018-04-25 00:00","title":"人面桃花相映红","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/24/06/20180424063202231-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8334227-0-1.html"},{"ctime":"2018-04-25 10:00","title":"紫春","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/25/09/20180425091032981-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8336584-0-1.html"},{"ctime":"2018-04-25 10:00","title":"雾熙","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/25/09/20180425090828261-239867.gif","url":"http://bbs.voc.com.cn/mm/meinv-8336578-0-1.html"},{"ctime":"2018-04-26 20:00","title":"上国料萌衣~容貌和歌声格外醒目的美少女","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/26/18/2018042618574951-2053485.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8339976-0-1.html"},{"ctime":"2018-04-26 21:00","title":"☆成熟女人\u2026\u2026[妍希 151p]\u2026\u2026第988辑","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-04/26/20/201804262026445371-1559530.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8340081-0-1.html"}]
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
         * ctime : 2018-04-23 11:00
         * title : 老上海风情
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2018-04/23/07/20180423075206181-239867.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-8332060-0-1.html
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
}
