package com.kenny.controller;

import com.kenny.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ContentController
 * Function:  TODO
 * Date:      2020/5/31 20:12
 *
 * @author Kenny
 * version    V1.0
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/parse/{keywords}")
    public Boolean parse(@PathVariable("keywords") String keywords) throws Exception {
        return service.parseContent(keywords);
    }

    @RequestMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword,
                                            @PathVariable("pageNo") int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws IOException {
        return service.searchPage(keyword, pageNo, pageSize);
    }

}
