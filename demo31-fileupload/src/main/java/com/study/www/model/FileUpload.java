package com.study.www.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/3/1- 16:17
 * @Version: V1.0
 * @Modified By:
 **/
@Entity
@Table(name="file_upload")
@Data
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "files")
    private  byte[] files;

}
