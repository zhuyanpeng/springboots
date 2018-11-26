##邮件发送2-按照指定模板进行邮件的发送
*  本文利用的是freeamarker写的发送模板，若是其他模板引擎请自行修改
* `注意`：邮件发送一般离不开smtp服务器，一般smtp服务器都会占用25端口。若是[阿里](https://www.aliyun.com)或者[腾讯](https://cloud.tencent.com)云服务器其默认将25端口给屏蔽了请自行开启
* `注意`： 发送邮件的地址需开通SMTP服务
整合了h2和datajpa 