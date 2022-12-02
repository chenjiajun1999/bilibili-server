package com.bilibili.gatewayimpl.media;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.common.thirdparty.MinioStore;
import com.bilibili.common.thirdparty.RedisCache;
import com.bilibili.domain.media.gateway.MediaGatewayI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class MediaGatewayImpl implements MediaGatewayI {

}
