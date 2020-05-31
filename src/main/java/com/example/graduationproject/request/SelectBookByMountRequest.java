package com.example.graduationproject.request;

import lombok.Data;
import sun.awt.image.IntegerInterleavedRaster;

/**
 * @Author:Fengxutong
 * @Date:2020/2/16
 * @Description:小冯同学写点注释吧！
 */
@Data
public class SelectBookByMountRequest {

    private Integer mount;

    private Integer pageNumber=1;

    private Integer size=10;
}
