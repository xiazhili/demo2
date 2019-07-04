layui.define(['table'], exports => {
    let table = {
        render: (url,cols) => {
            //第一个实例
            layui.table.render({
                elem: '#demo'
                ,height: 312
                ,url: url //数据接口
                ,page: true //开启分页
                ,cols: [cols]
            });
        }
    }
    exports('customTable', table); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});