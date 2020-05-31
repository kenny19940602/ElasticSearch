package com.kenny.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Content
 * Function:  TODO
 * Date:      2020/5/31 20:06
 *
 * @author Kenny
 * version    V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;
}
