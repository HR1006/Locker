# Locker

## 开发环境
 - JDK1.8+
 
## 业务需求

需求描述：储物柜(Locker)可以存包、取包
![locker](./locker.png)

评分标准：参考Classroom中的评分标准Excel文档

### 需求澄清总结：
1. 储物柜没有容量限制
2. 储物柜没有尺寸限制，默认多大的包都能存
3. 硬件系统功能不需要考虑（开门/关门/按钮/停电/没票纸）
4. 存包失败，需要提示用户是因为储物柜满了
5. 取包失败，需要提示用户是因为票据无效
6. 存包的位置是随机，没有顺序
7. 不要脑补需求，及时和PO确认
8. 不考虑并发

### tasking
- Given: 一个有空位置的储物柜 When: locker存包 Then: 存包成功，返回票据
- Given: 一个无空位置的储物柜 When: locker存包 Then: 存包失败，提示储物柜已满
- Given: 一张有效小票 When: locker取包 Then: 取包成功
- Given: 一张伪造票据 When: locker取包 Then: 取包失败，提示非法票据
- Given: 一张重复使用的票据 When: locker取包， Then: 取包失败，提示非法票据
