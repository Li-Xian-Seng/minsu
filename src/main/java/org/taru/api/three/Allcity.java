package org.taru.api.three;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Story;
import org.taru.service.three.AllstoryService;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
public class Allcity {
    @Autowired
    AllstoryService city;


    @ApiOperation(value="查询热门城市",notes="无参数")
    @RequestMapping(value = "/api/querycity",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public JsonResult queryPri(){
        JsonResult jsonclass = null;
        try {
            List<Story> allcity = city.allstorycity();
            if(allcity==null){
                jsonclass = new JsonResult("400","查询失败","");
            }else{
                jsonclass = new JsonResult("200","查询成功",allcity);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error",e.getMessage());
        }

        return jsonclass;
    }
}
