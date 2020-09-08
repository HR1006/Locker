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

### Locker tasking
- Given: 一个有空位置的储物柜 When: locker存包 Then: 存包成功，返回票据
- Given: 一个无空位置的储物柜 When: locker存包 Then: 存包失败，提示储物柜已满
- Given: 一张有效小票 When: locker取包 Then: 取包成功
- Given: 一张伪造票据 When: locker取包 Then: 取包失败，提示非法票据
- Given: 一张重复使用的票据 When: locker取包， Then: 取包失败，提示非法票据

### PrimaryLockerRobot tasking
- Given: 一个已经存满的储物柜 When: PrimaryLockerRobot存包 Then: 存包失败，提示储物柜已满
- Given: 两个储物柜，第一个已满，第二个有空位置 When: PrimaryLockerRobot存包 Then: 成功存包到第二个储物柜，返回票据
- Given: 两个储物柜，第一个有空位置，第二个也有空位置 When: PrimaryLockerRobot存包 Then: 成功存包到第一个储物柜，返回票据
- Given: 一张有效小票，包存在第一个储物柜 When: PrimaryLockerRobot取包 Then: 取包成功
- Given: 一张有效小票，包存在第二个储物柜 When: PrimaryLockerRobot取包 Then: 取包成功
- Given: 一张伪造票据 When: PrimaryLockerRobot取包 Then: 取包失败，提示非法票据
- Given: 一张重复使用的票据 When: PrimaryLockerRobot取包， Then: 取包失败，提示非法票据

### SmartLockerRobot tasking
- Given: SmartLockerRobot管理一个Locker且已经存满 When: SmartLockerRobot存包 Then: 存包失败，提示储物柜已满
- Given: SmartLockerRobot管理两个Locker，第一个剩余容量为2，第二个剩余容量为1 When: SmartLockerRobot存包 Then: 成功存包到第一个Locker，返回票据
- Given: SmartLockerRobot管理两个Locker，第一个剩余容量为1，第二个剩余容量为2 When: SmartLockerRobot存包 Then: 成功存包到第二个Locker，返回票据
- Given: SmartLockerRobot管理两个Locker，第一个剩余容量为1，第二个剩余容量为1 When: SmartLockerRobot存包 Then: 成功存包到第一个Locker，返回票据
- Given: 一张有效票据 When: SmartLockerRobot取包 Then: 取包成功
- Given: 一张无效票据 When: SmartLockerRobot取包 Then: 取包失败，提示非法票据

### LockerRobotManager tasking
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，且都未存满 When: LockerRobotManager存包 Then: 成功存包到PrimaryLockerRobot的第一个非空Locker，返回票据
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，且只有PrimaryLockerRobot已存满 When: LockerRobotManager存包 Then: 成功存包到SmartLockerRobot剩余容量最大的Locker，返回票据
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，且只有LockerRobotManager管理的两个Locker未存满 When: LockerRobotManager存包 Then: 成功存包到LockerRobotManager管理的第一个Locker，返回票据
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，且只有LockerRobotManager管理的第二个Locker未存满 When: LockerRobotManager存包 Then: 成功存包到LockerRobotManager管理的第二个Locker，返回票据
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，且都已经存满 When: LockerRobotManager存包 Then: 存包失败，提示储物柜已满
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，一张有效票据（包存在PrimaryLockerRobot管理的Locker里） When: LockerRobotManager取包 Then: 取包成功
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，一张无效票据（包存在PrimaryLockerRobot管理的Locker里） When: LockerRobotManager取包 Then: 取包失败，提示非法票据
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，一张有效票据（包存在SmartLockerRobot管理的Locker里） When: LockerRobotManager取包 Then: 取包成功
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，一张无效票据（包存在SmartLockerRobot管理的Locker里） When: LockerRobotManager取包 Then: 取包失败，提示非法票据
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，一张有效票据（包存在LockerRobotManager管理的Locker里） When: LockerRobotManager取包 Then: 取包成功
- Given: LockerRobotManager管理一个PrimaryLockerRobot、一个SmartLockerRobot、两个Locker，一张无效票据（包存在LockerRobotManager管理的Locker里） When: LockerRobotManager取包 Then: 取包失败，提示非法票据
