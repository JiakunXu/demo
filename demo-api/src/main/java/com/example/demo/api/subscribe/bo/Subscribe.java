package com.example.demo.api.subscribe.bo;

import com.example.demo.framework.bo.BaseBo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @author JiakunXu
 */
@Getter
@Setter
public class Subscribe extends BaseBo {

    private static final long serialVersionUID = 4067360092344161155L;

    private BigInteger        id;

    private BigInteger        userId;

    private String            appId;

    /**
     * 场景.
     */
    private String            scene;

    private BigInteger        sceneId;

}
