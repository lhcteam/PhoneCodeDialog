# 使用方法
## 导入
```
    compile project(':phonecode')
```
## 使用
1.
```
修改 assets>CounrtyCode.json 把默认的放在第一个位置
```
2.
```
String[] country = DialogManager.initmPopupDialog(context, tv_code, tv_name,defaultCode,defaultName);
```
