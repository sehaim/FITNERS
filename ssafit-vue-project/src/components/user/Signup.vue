<template>
  <div id="signup-container">
    <div id="field-name">
      <div>회원가입</div>
      <hr />
      <div
        :class="activeClass"
        class="alert d-flex align-items-center"
        role="alert"
      >
        <i
          class="bi bi-exclamation-circle-fill flex-shrink-0 me-2"
          width="10"
          height="10"
          aria-label="Warning:"
          v-if="iconCheck"
        ></i>
        <div id="alert-msg" v-if="idCheck">아이디를 입력해주세요.</div>
        <div id="alert-msg" v-if="idLengthCheck">
          아이디는 8자 이상 20자 이하입니다.
        </div>
        <div id="alert-msg" v-if="idElementCheck">
          아이디는 영문, 숫자만 포함 가능합니다.
        </div>
        <div id="alert-msg" v-if="nameCheck">이름을 입력해주세요.</div>
        <div id="alert-msg" v-if="nameLengthCheck">이름은 10자 이하입니다.</div>
        <div id="alert-msg" v-if="nameElementCheck">
          이름은 한글로 입력해야 합니다.
        </div>
        <div id="alert-msg" v-if="passwordCheck">비밀번호를 입력해주세요.</div>
        <div id="alert-msg" v-if="passwordLengthCheck">
          비밀번호는 8자 이상 20자 이하입니다.
        </div>
        <div id="alert-msg" v-if="passwordElementCheck">
          비밀번호는 반드시 영문, 숫자, 특수문자를 포함해야 합니다.
        </div>
      </div>
    </div>
    <div id="signup-form">
      <div id="signup-input">
        <label for="userId">아이디</label>
        <input
          type="text"
          id="userId"
          class="form-check-input"
          v-model.trim="user.userId"
          placeholder=" 8~20자 (영문, 숫자)"
        />
      </div>
      <div id="signup-input">
        <label for="userName">이름</label>
        <input
          type="text"
          id="userName"
          class="form-check-input"
          v-model="user.userName"
          placeholder=" 실명"
        />
      </div>
      <div id="signup-input">
        <label for="userPassword">비밀번호</label>
        <input
          type="password"
          id="userPassword"
          class="form-check-input"
          v-model.trim="user.userPassword"
          placeholder=" 8~20자 (영문, 숫자, 특수문자)"
          required
        />
      </div>
      <div id="signup-input">
        <label for="passwordOK">비밀번호 확인</label>
        <input
          type="password"
          id="passwordOK"
          class="form-check-input"
          v-model.trim="passwordOK"
        />
      </div>
      <div
        id="alert"
        :style="{ color: activeColor }"
        v-if="passwordOK !== user.userPassword"
      >
        비밀번호를 확인해주세요.
      </div>
      <div id="alert-ok" v-else>비밀번호가 일치합니다.</div>
      <div id="signup-input">
        <label for="isManager">회원 유형</label>
        <select
          name="isManager"
          id="type"
          class="form-select"
          v-model="user.isManager"
        >
          <option :value="false">일반 회원</option>
          <option :value="true">매니저</option>
        </select>
      </div>
    </div>
    <div
      :class="store.activeSignupErrClass"
      class="alert d-flex align-items-center"
      role="alert"
    >
      <i
        class="bi bi-exclamation-circle-fill flex-shrink-0 me-2"
        width="10"
        height="10"
        aria-label="Warning:"
        v-if="store.signupErr"
      ></i>
      <div id="alert-msg" v-if="store.signupErr">중복된 아이디 입니다.</div>
    </div>
    <button id="signup-btn" @click="signup">가입</button>
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from "vue";
import { useUserStore } from "@/stores/user.js";

const store = useUserStore();

const user = ref({
  userId: null,
  userName: null,
  userPassword: null,
  isManager: false,
});

onMounted(() => {
  store.signupErr = false;
  store.activeSignupErrClass = "";
});

const passwordOK = ref("");

const pattern1 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
const pattern2 = /[~!@#\#$%<>^&*]/;
const pattern3 = /[0-9]/;
const pattern4 = /[a-zA-Z]/;

const activeClass = ref("");
const iconCheck = ref(false);
const idCheck = ref(false);
const idLengthCheck = ref(false);
const idElementCheck = ref(false);
const nameCheck = ref(false);
const nameLengthCheck = ref(false);
const nameElementCheck = ref(false);
const passwordCheck = ref(false);
const passwordLengthCheck = ref(false);
const passwordElementCheck = ref(false);

const signup = function () {
  activeClass.value = "";
  iconCheck.value = false;
  idCheck.value = false;
  idLengthCheck.value = false;
  idElementCheck.value = false;
  nameCheck.value = false;
  nameLengthCheck.value = false;
  nameElementCheck.value = false;
  passwordCheck.value = false;
  passwordLengthCheck.value = false;
  passwordElementCheck.value = false;

  if (user.value.userId === null) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    idCheck.value = true;
  } else if (user.value.userId.length < 8 || user.value.userId.length > 20) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    idLengthCheck.value = true;
  } else if (
    pattern1.test(user.value.userId) ||
    pattern2.test(user.value.userId)
  ) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    idElementCheck.value = true;
  } else if (user.value.userName === null) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    nameCheck.value = true;
  } else if (user.value.userName > 10) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    nameLengthCheck.value = true;
  } else if (
    pattern2.test(user.value.userName) ||
    pattern3.test(user.value.userName) ||
    pattern4.test(user.value.userName)
  ) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    nameElementCheck.value = true;
  } else if (user.value.userPassword === null) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    passwordCheck.value = true;
  } else if (user.value.userPassword < 8 || user.value.userPassword > 20) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    passwordLengthCheck.value = true;
  } else if (
    !pattern2.test(user.value.userPassword) ||
    !pattern3.test(user.value.userPassword) ||
    !pattern4.test(user.value.userPassword) ||
    pattern1.test(user.value.userPassword)
  ) {
    activeClass.value = "alert-warning";
    iconCheck.value = true;
    passwordElementCheck.value = true;
  } else if (
    user.value.userId !== null &&
    user.value.userName !== null &&
    user.value.userPassword !== null &&
    passwordOK.value === user.value.userPassword
  ) {
    store.signup(user.value);
  }
};
</script>

<style scoped>
#signup-container {
  width: 400px;
  height: 600px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding-top: 20px;
  padding-bottom: 20px;
  margin: 2% auto;
}

#field-name {
  font-size: 25px;
  text-align: center;
}

#signup-form {
  height: 300px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 5px 0;
}

#signup-input {
  width: 300px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  font-size: 15px;
}

input,
select {
  font-size: 13px;
  height: 35px;
  width: 200px;
  border-radius: 5px;
}

#signup-btn {
  width: 200px;
  height: 40px;
  border-style: none;
  font-size: 16px;
  border-radius: 5px;
  background-color: #ffdc5cc3;
  color: rgb(95, 94, 94);
}

hr {
  width: 300px;
}

#alert {
  font-size: 12px;
  color: rgb(207, 24, 24);
  text-align: right;
}

#alert-ok {
  font-size: 12px;
  color: rgb(34, 34, 177);
  text-align: right;
}

.alert {
  width: 300px;
  height: 50px;
  margin: 0;
}

#alert-msg {
  font-size: 13px;
  text-align: left;
}
</style>
