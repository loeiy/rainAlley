package com.alley.rain.enums;

public enum ActionCodeEnum {

    //基本结果 0-9
    ActionFailed(0),// 操作失败
    ActionSuccessed(1),// 操作成功
    AccountLocked(2),//账号锁定
    AccountLogout(3),// 账号已登出
    AccountNew(4),// 新账户
    NothingChanged(5),// 无需更改
    ConnectionLost(6),// 连接中断
    WebsiteClosed(7),// 网站关闭
    ParamError(9),// 参数错误

    //权限相关 10-19
    Unauthorized(10),// 未授权
    RoleMiss(11),// 角色不存在
    ModuleMiss(12),// 权限不存在
    AlreadyAudited(13),//已审核

    // 账号密码相关 30-60
    PasswordError(30),// 密码错误
    AccountNotExist(31),// 账号不存在
    PasswordTheSame(32),// 密码一致，无需更改
    StateTheSame(33),// 状态一致，无需更改
    PowerTypeNotFound(36),// 权限类型未找到
    AccountNameUsed(37),// 名称已被使用
    TwoFactorPassError(38),// 二步验证错误
    NeedTwoFactorPass(39),// 需要二步验证
    EmailBeenTaken(40),// 邮箱已被注册
    LoginNameBeenTaken(41),// 登陆名已被使用
    AccountActived(42),// 账号已激活
    AccountInactive(43),// 账户未激活
    MailCodeExpired(44),// 邮件验证过期
    MailJustSend(45),// 邮件刚发送
    PasswordExpired(46),// 密码过期
    ActionPasswordExpired(47),// 操作密码过期
    ActionPasswordError(48),// 操作密码错误
    TwoFactorPassEnabled(49),// 二步验证已启用
    ActionPasswordSet(50),// 已经设置过操作密码
    AccountINVALID(51),//账号已失效
    CanNotResetSelf(52),//禁止对自身进行重置

    // 商户相关 61-100
    MerchantNotExist(61),// 商户不存在
    MerchantMasterAccountNotExist(62),//商户主账户不存在
    MerchantSecurityNotExist(63),//商户秘钥不存在

    //余额相关
    BalanceFreezeFail(64),//冻结失败
    UseBalanceNotEnough(65),// 可用余额不足
    FreezeBalanceLess(66),// 冻结余额不足
    ClearBalanceLess(67),// 未清算余额不足
    MerchantGatewayNotExist(68),// 商户网关不存在
    BalanceUnFreezeFail(69),//解冻失败
    UseBalanceEnough(71),// 余额充足
    CurrencyAccountNotExist(72),// 币种账户尚未开通
    MerchantNotAvalible(73),// 商户不可用
    FundAccountNotAvalible(74),//资金账户异常
    MainFundAccountNotExit(75),//主账户不存在

    AgentNotExist(76),// 代理商不存在
    MerchantProductNotExist(77),// 商户产品不存在
    RegistClosed(80),// 注册已关闭
    AgentIdIsNotNull(81),//代理商编号不能为空
    AuthedTransTypeIsNotNull(82),//授权的交易类型不能为空
    CustomRateSchemaIdIsNotNull(83),//授权的费率模板不能为空
    EnabledIsNotNull(84),//开通状态不能为空
    ProductCodeIsNotNull(85),//产品ID不能为空
    RouteIdIsNotNull(86),//路由列表不能为空
    RateSchemaIdIsNotNull(87),//代理商分润模板不能为空
    AgentProductExist(88),//该代理商下此产品已存在

    //用户相关
    UserEmailExist(89),//用户注册邮箱已存在
    UserNotExist(90),//用户不存在
    RoleInfoNotExist(91),//角色不存在
    UserTypeIsInconsistent(94),//用户类型不一致
    // 银行信息相关 101-120
    CardBinInfoNotExist(101), //卡bin信息不存在
    CardBinInfoCardLenIsNull(102),//卡bin信息的卡长度为空
    CardBinInfoCardBinIsNull(103),//卡bin信息的卡bin为空
    CardBinInfoCardBinLen(104),//卡bin信息的卡BIN长度为空
    EncryptFail(105),//加密失败
    DecryptFail(106),//解密失败
    // 渠道相关 121-140
    ChannelNotExist(121),// 渠道不存在
    ChannelGatewayNotExist(122),// 渠道网关不存在
    ChannelGatewayActived(123),// 渠道网关已激活
    ChannelGatewayInUse(124),// 渠道网关正在使用
    ChannelInUse(125),// 渠道正在使用
    ChannelActived(126),// 渠道已激活
    ChannelBankCodeNotExist(127),// 渠道银行代码不存在
    ChannelIPInUse(128),// 渠道ip白名单正在使用
    ChannelCurrencyInUse(129),// 渠道货币已存在
    CurrencyCodeNoExist(130),// 货币代码不存在
    ChannelCurrencyNoExist(131),// 渠道货币不存在
    ChannelPayTypeNotExist(132),// 渠道下发支付类型不存在
    ChannelConstrainNotExist(133),//渠道约束不存在
    ChannelNotAvalible(134),//无可用渠道
    RouteNotExist(135),//无路由
    RouteRuleNotExist(136),//路由规则不存在
    RouteChannelNotExist(137),//路由渠道不存在
    ChannelSpIdIsNullPrivateMustFalse(138),//SpId为0则IsPrivate必须为false
    ChannelSpIdNotNullPrivateMustTrue(139),//SpId不为0则IsPrivate必须为true
    ChannelNameIsNull(140),//渠道名称为空
    ChannelBankIdIsNull(142),//渠道合作机构ID为空
    ChannelBankSettleTypeIsNull(143),//渠道清算方式为空
    ChannelBankSpIdIsNull(144),//渠道商户号为空
    ChannelRateSchemaIdIsNull(145),//渠道费率方案ID为空
    ChannelConstraintIdIsNull(146),//渠道约束ID为空
    ChannelCurrencyIsNull(147),//渠道货币类型为空
    ChannelJsonParaIsNull(148),//渠道特有的参数为空

    // 邮件配置 151-160
    MailConfigNotExist(151),// 邮件配置不存
    MailTemplateNotExist(152),// 邮件模板不存在

    // 订单相关 160-180
    OrderNotExist(161),//订单不存在
    PayNotExist(162),//支付订单不存在
    OrderSaveFail(164),//订单保存失败
    PaySaveFail(165),//支付订单保存失败
    OrderExists(166),//订单已存在
    PayExists(167),//支付订单已存在
    OrderStateError(168),//订单状态异常
    PayBillNotExist(169),//付款单不存在
    GatherNotExist(170),//收款单不存在
    // 费率相关 251-260
    FeeMinLimitError(251),// 费率下限额度错误
    FeeMaxLimitError(252),// 费率上限额度错误
    FeeNotFound(253),// 费率未找到

    // 系统配置相关 261-280
    MessageThreadConfigNotExist(261),// 消息线程配置不存在
    ConfigFileNoeExit(262),//配置文件不存在 API_ERROE_CODE_0063
    QueryRateError(263),//查询汇率失败
    IdCardFormatError(264),//身份证格式错误
    ConfigError(265),//配置错误
    GenNewSerialFail(266),//生成新序列号失败
    VersionInfoNotExist(267),//版本信息不存在

    //远程文件相关 281-300
    LoadFileError(281), //获取文件失败 API_ERROE_CODE_0062 API_ERROE_CODE_0064

    //公告相关 300 - 310
    NoticeIdNotExist(310),//公告不存在

    //商户银行卡相关 311 - 320
    SpDefaultCardNotPermitDelete(311),//商户默认卡禁止删除
    SPCardNotFound(312),//商户卡未找到
    CardEncryptionFailed(313),//商户卡未找到

    //场景 321 - 330
    ScenesNotExist(321),//场景不存在
    ScenesGroupNotExist(322),//场景组不存在
    ScenesGroupExist(323),//场景组已存在
    ScenesExist(324),//场景已存在
    //交易返回相关 10000开始
    TransSuccessed(10000),//交易成功 API_ERROE_CODE_0000
    TransProcessing(10001),//交易处理中 API_ERROE_CODE_P000
    TransWaidAuthCard(10002),//等待鉴权绑卡 API_ERROE_CODE_T000
    TransWaitingSMS(10003),//等待短信验证 API_ERROE_CODE_S000
    TransPrarmError(10004),//参数非法 API_ERROE_CODE_0001
    TransMerchantEmpty(10005),//商户号为空 API_ERROE_CODE_0002
    TransMerchantOrderEmpty(10006),//商户订单号为空 API_ERROE_CODE_0003
    TransBankPhoneEmpty(10007),//银行预留手机号为空 API_ERROE_CODE_0004
    TransAmountEmpty(10008),//金额为空 API_ERROE_CODE_0005
    TransCardEmpty(10009),//卡号为空 API_ERROE_CODE_0006
    TransCVV2Empty(10010),//CVV2为空 API_ERROE_CODE_0007
    TransCardValidDateEmpty(10011),//卡有效期为空 API_ERROE_CODE_0008
    TransSignedInfoEmpty(10012),//签名数据为空 API_ERROE_CODE_0009
    TransMerchantNotExist(10013),//商户信息不存在 API_ERROE_CODE_0010
    TransMerchantNotValid(10014),//商户状态异常 API_ERROE_CODE_0011
    TransSignatureError(10015),//验签失败 API_ERROE_CODE_0012 API_ERROE_CODE_0013 API_ERROE_CODE_0014 API_ERROE_CODE_0015
    TransProductError(10016),//产品信息出错 API_ERROE_CODE_0016 API_ERROE_CODE_0019 API_ERROE_CODE_0017
    TransUnauthorized(10017),//未授权交易 API_ERROE_CODE_0018
    TransCardNotSupport(10018),//不支持的卡 API_ERROE_CODE_0020 API_ERROE_CODE_0021 API_ERROE_CODE_0022
    TransOrderExisted(10019),//订单重复 API_ERROE_CODE_0023
    TransOrderSaveFail(10020),//订单保存失败 API_ERROE_CODE_0024 API_ERROE_CODE_0043
    TransChannelSignError(10021),//渠道签名失败 API_ERROE_CODE_0025
    TransPaySaveFail(10022),//支付信息保存失败 API_ERROE_CODE_0026
    TransUnknowTransType(10023),//未知交易类型 API_ERROE_CODE_0027
    TransOrderNotExist(10024),//订单不存在 API_ERROE_CODE_0028
    TransOrderStateExcept(10025),//订单状态异常 API_ERROE_CODE_0029 API_ERROE_CODE_0044 API_ERROE_CODE_0045
    TransAmountExceed(10026),//订单金额超限 API_ERROE_CODE_0030 API_ERROE_CODE_0046
    TransRouteError(10027),//路由错误 API_ERROE_CODE_0031
    TransAmountError(10028),//交易金额错误 API_ERROE_CODE_0032
    TransCardSaveError(10029),//银行卡信息保存失败 API_ERROE_CODE_0033
    TransCanotRefund(10030),//不能退款 API_ERROE_CODE_0034 API_ERROE_CODE_0061
    TransCanotCancel(10031),//不能撤销 API_ERROE_CODE_0036
    TransCanceled(10032),//订单已撤销 API_ERROE_CODE_0035 API_ERROE_CODE_0037
    TransRefunded(10033),//订单已退款 API_ERROE_CODE_0037
    TransCanceling(10034),//订单正在撤销 API_ERROE_CODE_0040
    TransRefunding(10035),//订单正在退款 API_ERROE_CODE_0041
    TransBalanceNotEnough(10036),//余额不足 API_ERROE_CODE_0042
    TransAmountNotMatch(10037),//交易金额不匹配 API_ERROE_CODE_0047
    TransBankIdNotExist(10038),//联行号不存在 API_ERROE_CODE_0048
    TransNotTransTime(10039),//当前时间不允许交易 API_ERROE_CODE_0049
    TransTimeFormatError(10040),//时间格式错误 API_ERROE_CODE_0050 API_ERROE_CODE_0057
    TransTooMuchSMSRequest(10041),//过多短信请求 API_ERROE_CODE_0051
    TransPhoneError(10042),//手机号错误 API_ERROE_CODE_0052
    TransNoVerifyCode(10043),//未获取验证码 API_ERROE_CODE_0054
    TransNoSMSNeed(10044),//不需要短信验证码 API_ERROE_CODE_0060
    TransVerifyCodeError(10045),//短信验证码错误 API_ERROE_CODE_0053 API_ERROE_CODE_0055 API_ERROE_CODE_0056
    TransVerifyCodeExpired(10046),//短信验证码过期 API_ERROE_CODE_0065
    TransQueryTimeError(10047),//查询时间错误 API_ERROE_CODE_0058
    TransBindCardError(10048),//绑卡失败 API_ERROE_CODE_0067
    TransCardTypeNotMatch(10049),//卡类型不匹配 API_ERROE_CODE_0068 API_ERROE_CODE_0066
    TransCardError(10050),//卡信息异常 API_ERROE_CODE_0059
    TransCurrencyError(10051),//币种错误 API_ERROE_CODE_0069
    TransFinishedError(10052),//订单已完成 API_ERROE_CODE_0039
    TransChannelNotFound(10053),//渠道未找到
    TransChannelConstaintNotFound(10054),//渠道约束未找到
    TransBankNotFound(10055),//机构未找到
    TransReady(10056),//准备交易，用于二维码生成 API_ERROE_CODE_0000
    TransReceivingError(10057),//收付款订单操作失败



    TransResultUnknow(19997),//结果未知 API_ERROE_CODE_9997
    TransResultFail(19998),//交易失败 API_ERROE_CODE_9998
    TransResultSystemError(19999),//系统异常 API_ERROE_CODE_9999



    UNKNOWN(99999);

    private int value;

    public int getValue() {
        return value;
    }

    public String getValueStr() {
        return String.valueOf(value);
    }

    ActionCodeEnum(int value) {
        this.value = value;
    }

    public static ActionCodeEnum fromShort(short value) {
        for (ActionCodeEnum val : ActionCodeEnum.values()) {
            if (value == val.getValue()) {
                return val;
            }
        }
        return ActionCodeEnum.UNKNOWN;
    }



    public static ActionCodeEnum fromString  (String name) {
        for (ActionCodeEnum val : ActionCodeEnum.values()) {
            if (val.name().equals(name)) {
                return val;
            }
        }
        return ActionCodeEnum.UNKNOWN;
    }
}
