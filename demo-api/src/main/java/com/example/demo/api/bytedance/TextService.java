package com.example.demo.api.bytedance;

import com.example.demo.api.bytedance.ao.text.Body;
import com.example.demo.api.bytedance.ao.text.Log;

/**
 * @author JiakunXu
 */
public interface TextService {

    String HTTPS_DETECT_URL = "https://developer.toutiao.com/api/v2/tags/text/antidirt";

    /**
     *
     * @param accessToken
     * @param body
     * @return
     * @throws RuntimeException
     */
    Log detect(String accessToken, Body body) throws RuntimeException;

}
