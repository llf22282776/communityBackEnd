package com.lubao.forbackend.controller;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lubao.forbackend.domain.CommentMix;
import com.lubao.forbackend.domain.CommentMix_2;
import com.lubao.forbackend.domain.CommentTable;
import com.lubao.forbackend.domain.CoversionMix;
import com.lubao.forbackend.domain.CoversionRequest;
import com.lubao.forbackend.domain.CoversionTable;
import com.lubao.forbackend.domain.NidAndCid;
import com.lubao.forbackend.domain.NidsRequest;
import com.lubao.forbackend.domain.PersonalTable;
import com.lubao.forbackend.domain.SupportRequest;
import com.lubao.forbackend.domain.Test;
import com.lubao.forbackend.service.CommentService;
import com.lubao.forbackend.service.CoversionService;
import com.lubao.forbackend.service.PersonalService;
import com.lubao.forbackend.util.Constant;

@Controller
@RequestMapping("api")
public class DbController {

    @Resource
    private CommentService commentServiceImp;
    @Resource
    private CoversionService coversionServiceImp;

    @Resource
    private PersonalService personalServiceImp;

    // 获得帖子
    @RequestMapping(value = "coversion/getCoversionList", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getCoversionList(@RequestParam("nid") String nid) {
        // 暂时用，获得一个
        System.out.println("获得帖子");
        JSONObject bigjJsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CoversionMix[] mixs = coversionServiceImp.getCoversions();
        int index = 0;
        for (CoversionMix coversionMix : mixs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", coversionMix.getCid());
            jsonObject.put("nid", coversionMix.getNid());
            jsonObject.put("titleText", coversionMix.getTitle());
            jsonObject.put("contentText", coversionMix.getContent());
            jsonObject.put("supportNum", coversionMix.getSupportNum());
            jsonObject.put("commitNums", coversionMix.getCommentNum());
            jsonObject.put("nick", coversionMix.getNick());
            jsonObject.put("url", coversionMix.getImageUrl());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(coversionMix.getDate()));
            jsonObject.put("index", index);
            jsonObject.put("thumbnail", coversionMix.getThumbnail());
            NidAndCid nidAndCid = new NidAndCid();
            nidAndCid.setCid(coversionMix.getCid());
            nidAndCid.setNid(Integer.parseInt(nid));
            boolean isSupprot = coversionServiceImp.isSupport(nidAndCid);
            if (isSupprot == true)
                jsonObject.put("isSupport", "true");
            else
                jsonObject.put("isSupport", "false");
            index++;
            jsonArray.add(jsonObject);// 放进来
        }
        bigjJsonObject.put("coversionList", jsonArray);
        return bigjJsonObject;
    }
    // 获得帖子
    @RequestMapping(value = "coversion/getCoversionByCid", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getCoversionByCid(@RequestParam("cid") int cid,@RequestParam("nid") int nid) {
        System.out.println("获得帖子,一个");
        JSONObject jsonObject = new JSONObject();
        CoversionMix coversionMix=coversionServiceImp.getCoversionMix(cid);
        jsonObject.put("cid", coversionMix.getCid());
        jsonObject.put("nid", coversionMix.getNid());
        jsonObject.put("titleText", coversionMix.getTitle());
        jsonObject.put("contentText", coversionMix.getContent());
        jsonObject.put("supportNum", coversionMix.getSupportNum());
        jsonObject.put("commitNums", coversionMix.getCommentNum());
        jsonObject.put("nick", coversionMix.getNick());
        jsonObject.put("url", coversionMix.getImageUrl());
        jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(coversionMix.getDate()));
        jsonObject.put("thumbnail", coversionMix.getThumbnail());
        NidAndCid nidAndCid = new NidAndCid();
        nidAndCid.setCid(coversionMix.getCid());
        nidAndCid.setNid(nid);
        boolean isSupprot = coversionServiceImp.isSupport(nidAndCid);
        if (isSupprot == true)
            jsonObject.put("isSupport", "true");
        else
            jsonObject.put("isSupport", "false");
        return jsonObject;
        
        
        
    }
    // 获得评论，根据cid
    @RequestMapping(value = "comment/getCommentList", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getCommentList(@RequestParam("cid") int cid) {
        // 获取一个coversion的commentList
        System.out.println("获得评论，根据cid");
        JSONObject bigjJsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CommentMix[] commentMixs = commentServiceImp.getCommentMixsByID(cid);

        int index = 0;
        for (CommentMix commentMix : commentMixs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", commentMix.getCid());
            jsonObject.put("nid", commentMix.getNid());
            jsonObject.put("content", commentMix.getContent());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(commentMix.getDate()));
            jsonObject.put("nick", commentMix.getNick());
            jsonObject.put("thumbnail", commentMix.getThumbnail());
            jsonObject.put("index", index);
            index++;
            jsonArray.add(jsonObject);// 放进来
        }

        bigjJsonObject.put("commentList", jsonArray);
        return bigjJsonObject;
    }

    // 搜索帖子
    @RequestMapping(value = "coversion/searchCoversionList", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject searchCovesionList(
            @RequestParam("keyword") String keyword,
            @RequestParam("nid") String nid) {
        System.out.println(" 搜索帖子 keyword:" + keyword);
        
        JSONObject bigjJsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CoversionMix[] coversionMixs = coversionServiceImp
                .searchCoversions(keyword);
        int index = 0;
        for (CoversionMix coversionMix : coversionMixs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", coversionMix.getCid());
            jsonObject.put("nid", coversionMix.getNid());
            jsonObject.put("titleText", coversionMix.getTitle());
            jsonObject.put("contentText", coversionMix.getContent());
            jsonObject.put("supportNum", coversionMix.getSupportNum());
            jsonObject.put("commitNums", coversionMix.getCommentNum());
            jsonObject.put("nick", coversionMix.getNick());
            jsonObject.put("url", coversionMix.getImageUrl());
            jsonObject.put("thumbnail", coversionMix.getThumbnail());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(coversionMix.getDate()));
            jsonObject.put("index", index);
            NidAndCid nidAndCid = new NidAndCid();
            nidAndCid.setCid(coversionMix.getCid());
            nidAndCid.setNid(Integer.parseInt(nid));
            boolean isSupprot = coversionServiceImp.isSupport(nidAndCid);
            if (isSupprot == true)
                jsonObject.put("isSupport", "true");
            else
                jsonObject.put("isSupport", "false");
            index++;
            jsonArray.add(jsonObject);// 放进来
        }
        bigjJsonObject.put("coversionList", jsonArray);
        return bigjJsonObject;

    }

    // 插入评论
    @RequestMapping(value = "comment/insertComment", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject insertComment(@RequestParam("nid") int nid,
            @RequestParam("cid") int cid,
            @RequestParam("content") String content,
            @RequestParam("date") String date) {
        // 插入一个评论,相关的评论的数量加1,然后返回新的列表
        System.out.println("插入评论");
        CommentTable commentTable = creatOneComment(cid, nid, content, date);

        coversionServiceImp.upDateCoversion(cid);// 更新
        int rowsNum = commentServiceImp.insertComment(commentTable);
        return getCommentMixsMethod(cid, rowsNum);// 返回新的评论，方法不可取
    }

    // 插入帖子
    @RequestMapping(value = "coversion/insertCoversion", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject insertCoversion(@RequestParam("nid") int nid,
            @RequestParam("content") String content,
            @RequestParam("date") String date,
            @RequestParam("title") String title) throws ParseException {
        // 插入一个话题，返回新话题
        System.out.println("插入帖子 ");
        CoversionTable coversionTable = creatOneCoversion(nid, title, content,
                date);
        int rowsNum = coversionServiceImp.insertCoversion(coversionTable);

        return getCoversionMixsMethod(nid, rowsNum);// 返回新的评论，方法不可取

    }

    // json方式获得评论表
    @RequestMapping(value = "comment/getCommentList_json", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getCommentListByJson(@RequestBody Test test) {
        System.out.println("json方式获得评论表");
        int cid = test.getCid();
        JSONObject bigjJsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CommentMix[] commentMixs = commentServiceImp.getCommentMixsByID(cid);

        int index = 0;
        for (CommentMix commentMix : commentMixs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", commentMix.getCid());
            jsonObject.put("nid", commentMix.getNid());
            jsonObject.put("content", commentMix.getContent());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(commentMix.getDate()));
            jsonObject.put("nick", commentMix.getNick());
            jsonObject.put("thumbnail", commentMix.getThumbnail());
            jsonObject.put("index", index);
            index++;
            jsonArray.add(jsonObject);// 放进来
        }
        bigjJsonObject.put("commentList", jsonArray);
        return bigjJsonObject;
    }

    // 点赞 comment/upDateSupportNums
    @RequestMapping(value = "comment/upDateSupportNums", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject upDateSupportNums(@RequestBody SupportRequest sRequest) {
        JSONObject bigjJsonObject = new JSONObject();
        System.out.println("点赞 comment/upDateSupportNums");
        int state = coversionServiceImp.supportCoversionOrNot(
                sRequest.getCid(), sRequest.getNid(), sRequest.getType());
        bigjJsonObject.put("nowState", state);// 应该和传过来的state一样
        return bigjJsonObject;
    }

    // 获得个人信息
    @RequestMapping(value = "personal/getPersonalMsg", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getPersonalMsg(@RequestParam("nid") int nid) {
        System.out.println("获得个人信息");
        PersonalTable pTable = personalServiceImp.getPersonMsgById(nid);
        JSONObject biJsonObject = new JSONObject();
        /*
         * 
         * nid nick sex thumbnail passPort pwd phone
         */
        biJsonObject.put("nid", pTable.getNid());
        biJsonObject.put("nick", pTable.getNick());
        biJsonObject.put("sex", (int)pTable.getSex() == 1 ? "男":"女" );
        biJsonObject.put("passPort", pTable.getPassPort());
        biJsonObject.put("pwd", pTable.getPwd());
        biJsonObject.put("phone", pTable.getPhone());
        biJsonObject.put("thumbnail", pTable.getThumbnail());
        return biJsonObject;
        

    }
 // 获得个人未通知信息
    @RequestMapping(value = "personal/getMsgNew", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getMsgNew(@RequestParam("nid") int nid) {
        //自己的不应该在消息通知里面出现
        System.out.println("// 获得个人未通知信息");
        PersonalTable pTable = personalServiceImp.getPersonMsgById(nid);
        JSONObject biJsonObject = new JSONObject();
        CommentMix_2[] commentMixs=personalServiceImp.getMsgNew(nid);
        JSONArray jsonArray=new JSONArray();
        for (CommentMix_2 commentMix : commentMixs) {
            if(commentMix.getNid() == nid )continue;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", commentMix.getCid());
            jsonObject.put("nid", commentMix.getNid());
            jsonObject.put("content", commentMix.getContent());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(commentMix.getDate()));
            jsonObject.put("nick", commentMix.getNick());
            jsonObject.put("thumbnail", commentMix.getThumbnail());
            jsonObject.put("title", commentMix.getCoversionTitle());//返回相关的标题
            jsonArray.add(jsonObject);// 放进来
        }
        biJsonObject.put("commentList", jsonArray);
        return biJsonObject;
    }
  //登陆
    @RequestMapping(value = "personal/Login", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject Login(@RequestParam("passPort") String passPort,@RequestParam("pwd") String pwd){
        System.out.println("登陆:"+" "+passPort+" "+pwd);
        PersonalTable pTable=personalServiceImp.Login(passPort, pwd);
        JSONObject biJsonObject = new JSONObject();
        if(pTable != null){
            biJsonObject.put("nid", pTable.getNid());
            biJsonObject.put("nick", pTable.getNick());
            biJsonObject.put("sex", (int)pTable.getSex() == 1 ? "男":"女" );
            biJsonObject.put("passPort", pTable.getPassPort());
            biJsonObject.put("pwd", pTable.getPwd());
            biJsonObject.put("phone", pTable.getPhone());
            biJsonObject.put("thumbnail", pTable.getThumbnail());
            biJsonObject.put("isLogined","true");
        }else {
            biJsonObject.put("isLogined","false");
        }
        
        return biJsonObject;
        
    }
 // 获得个人未通知信息数量
    @RequestMapping(value = "personal/getMsgNewNums", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject getMsgNewNums(@RequestParam("nid") int nid) {
        System.out.println("获得个人未通知信息数量");
        JSONObject bigJsonObject=new JSONObject();
        bigJsonObject.put("nums", personalServiceImp.getNewsMsgNums(nid));
        return bigJsonObject;
    }
    
    // 设置未通知信息为已读
    @RequestMapping(value = "personal/setMsgViewed", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject setMsgViewed(@RequestBody NidsRequest nidsRequest) {
        System.out.println(" 设置未通知信息为已读");
        
        JSONObject biJsonObject = new JSONObject();
        int nums=personalServiceImp.setMsgViewed(nidsRequest.getCids(), nidsRequest.getNids());
        biJsonObject.put("nums", nums);
        System.out.println("nums:"+nums);
        return biJsonObject;
    } 
    // ------------------------------------------------------------------------
    public CommentTable creatOneComment(int cid, int nid, String content,
            String date) {
        CommentTable commentTable = new CommentTable();
        commentTable.setCid(cid);
        commentTable.setNid(nid);
        commentTable.setContent(content);
        commentTable.setDate(Timestamp.valueOf(date));
        return commentTable;
    }
    public CoversionTable creatOneCoversion(int nid, String title,
            String content, String date) throws ParseException {
        CoversionTable coversionTable = new CoversionTable();
        coversionTable.setNid(nid);// cid自己生成
        coversionTable.setTitle(title);
        coversionTable.setCommentNum(0);
        coversionTable.setSupportNum(0);
        coversionTable.setContent(content);

        coversionTable.setDate(Timestamp.valueOf(date));
        coversionTable.setImageUrl("");
        return coversionTable;

    }

    public CommentMix creatOneCommentMix(int cid, String content,
            Timestamp date, String nick, int nid) {
        CommentMix commentMix = new CommentMix();
        commentMix.setCid(cid);
        commentMix.setContent(content);
        commentMix.setDate(date);
        commentMix.setNick(nick);
        commentMix.setNid(nid);
        commentMix.setThumbnail("");// 应该是先上传图片，然后放在目录里，然后赋值
        return commentMix;

    }

    public CoversionMix creatOneCoversionMix() {
        return null;
    }

    public JSONObject getCommentMixsMethod(int cid, int rowNum) {
        JSONObject bigjJsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CommentMix[] commentMixs = commentServiceImp.getCommentMixsByID(cid);

        int index = 0;
        for (CommentMix commentMix : commentMixs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", commentMix.getCid());
            jsonObject.put("nid", commentMix.getNid());
            jsonObject.put("contentText", commentMix.getContent());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(commentMix.getDate()));
            jsonObject.put("nick", commentMix.getNick());
            jsonObject.put("thumbnail", commentMix.getThumbnail());
            jsonObject.put("index", index);
            index++;
            jsonArray.add(jsonObject);// 放进来
        }
        bigjJsonObject.put("commentList", jsonArray);
        bigjJsonObject.put("rowNum", rowNum);
        return bigjJsonObject;

    }

    public JSONObject getCoversionMixsMethod(int cid, int rowNum) {
        JSONObject bigjJsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CoversionMix[] mixs = coversionServiceImp.getCoversions();
        int index = 0;
        for (CoversionMix coversionMix : mixs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cid", coversionMix.getCid());
            jsonObject.put("nid", coversionMix.getNid());
            jsonObject.put("titleText", coversionMix.getTitle());
            jsonObject.put("contentText", coversionMix.getContent());
            jsonObject.put("supportNum", coversionMix.getSupportNum());
            jsonObject.put("commitNums", coversionMix.getCommentNum());
            jsonObject.put("nick", coversionMix.getNick());
            jsonObject.put("url", coversionMix.getImageUrl());
            jsonObject.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(coversionMix.getDate()));
            jsonObject.put("index", index);
            index++;
            jsonArray.add(jsonObject);// 放进来
        }
        bigjJsonObject.put("coversionList", jsonArray);
        bigjJsonObject.put("rowNum", rowNum);
        return bigjJsonObject;

    }

    // 以json的方式获得评论

    @Service
    class RequestBody_comment implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        private int cid;

    }
}
