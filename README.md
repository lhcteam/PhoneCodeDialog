# 使用方法
## 导入
```
    compile project(':PhoneCodeDialog-master')
```
## 使用
1.修改默认国家
```
修改 assets>CounrtyCode.json 把默认的放在第一个位置
```
2.显示dialog并返回国家代码及名字
```
String[] country = DialogManager.initmPopupDialog(context, tv_code, tv_name,defaultCode,defaultName);
```
