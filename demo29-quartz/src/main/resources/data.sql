--  每2分钟执行一次定时任务
insert into config(id,cron) values(1,'0/2 * * * * ?');