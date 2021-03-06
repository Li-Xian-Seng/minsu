package org.taru.api.four;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.taru.service.four.GuanzhuService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpSession;
//点击加为好友
@Controller
@CrossOrigin
public class GuanzhuApi {
    @Autowired
    GuanzhuService gs;
    @ApiOperation(value="点击加为好友",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户id", required = true, paramType = "int"),
            @ApiImplicitParam(name = "goodfriendid", value = "好友id", required = true, paramType = "int")
    })
    @RequestMapping(value ="/api/guanzhuapi",method = RequestMethod.GET)//提交评论的接口
    @ResponseBody
    public JsonResult guanzhuapi(
                                    @RequestParam("userid") int userid,
                                    @RequestParam("goodfriendid") int goodfriendid, HttpSession session) {

        JsonResult result = null;
        try {
            int p = gs.insertdiscussservice(userid,goodfriendid);


            if (p == 0) {
                result = new JsonResult("404", "评论失败", "gdf");
            } else {
                result = new JsonResult("200", "评论成功",p);
                session.setAttribute("selectsuccess",p);

            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "异常", "jfs");
        }
        return result;
    }
}
