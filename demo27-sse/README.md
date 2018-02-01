# 利用SSE技术进行数据的推送

##步骤
###1、得使用一个List<SseEmitter>去装当前需要进行服务推送的通道
     List<SseEmitter> emitterList=new ArrayList<>();    
###2、创建一个绑定的可被调用函数返回值必须是SseEmitter不然的话客户端的new Source（"/a"）会每间隔4秒进行一次轮询去判断
    
    @GetMapping("bind")
        public SseEmitter bind(){
            SseEmitter sseEmitter = new SseEmitter();
            emitterList.add(sseEmitter);
            return sseEmitter;
        }
####3、消息的推送可以直接选择对应的SseEmitter或者循环遍历List集合进行send发送
    
        emitterList.forEach((SseEmitter mitter)->{
                    try {
                        mitter.send(format, MediaType.APPLICATION_JSON);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
####4、页面首先需要进行判断是否支持EventSource然后进行对应的操作如下
    
     if (!!window.EventSource){
                /*去后台进行推送服务的绑定*/
                var source = new EventSource("/bind");
                s="";
                /*获得后端推送的信息*/
                source.addEventListener("message",function (e) {
                    s+=e.data+"<br/>";
                    document.getElementById("msgFromPush").innerHTML=s;
                });
                /*当绑定成功之后会触发open*/
                source.addEventListener("open",function (e) {
                    console.log("链接打开");
                });
                /*h5默认4秒钟进行一次推送的校验然后在此进行判断链接是否关闭了*/
                source.addEventListener("error",function (e) {
                    if(e.readyState==EventSource.CLOSED){
                        console.log("链接关闭");
                    }else{
                    }
                },false);
    
        }else {
            alert("服务器不支持SSE");
        }
        