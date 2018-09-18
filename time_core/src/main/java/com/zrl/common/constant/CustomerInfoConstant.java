package com.zrl.common.constant;

public class CustomerInfoConstant {
    // 用户绑定状态
    public enum BindingState {
        /**
         * 正常
         */
        NORMAL(1),
        /**
         * 失效
         */
        DENY(0);

        private Integer value;

        private BindingState(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
    // 用户绑定类型
    public enum BindingType {
        /**
         * 手机号
         */
        PHONE("bind01"),
        /**
         * Email
         */
        EMAIL("bind02"),
        /**
         * 身份证
         */
        CERTNO("bind03");
        private String value;

        private BindingType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
