关键词搜索（全文检索，最小长度为2）配置：

docker的mysql配置文件在：docker exec -it mysql01 /bin/bash中的etc/mysql/my.cnf中

在[mysqld]下添加 ft_min_word_len=1（mysql默认=4，=0时不开启全文检索）

使用 SHOW GLOBAL VARIABLES LIKE '%ft_%'; 检查是否修改成功

使用 alter table book add fulltext index keywords('keywords') with parser ngram    （book为表名， 前keywords为索引名，后keywords为数据库内字段名，with parser ngram设置中文分词 ）