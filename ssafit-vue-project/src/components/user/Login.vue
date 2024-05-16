<template>
  <div id="container">
    <div id="field-name">
      <div>로그인</div>
      <hr />
      <div
        :class="store.activeLoginErrClass"
        class="alert d-flex align-items-center"
        role="alert"
      >
        <i
          class="bi bi-exclamation-circle-fill flex-shrink-0 me-2"
          width="10"
          height="10"
          aria-label="Warning:"
          v-if="store.loginErr"
        ></i>
        <div id="alert-msg" v-if="store.loginErr">
          아이디/비밀번호를 확인해주세요.
        </div>
      </div>
    </div>
    <div id="login-form">
      <div id="login-input">
        <label for="userId">아이디</label>
        <input
          type="text"
          class="form-check-input"
          id="userId"
          v-model.trim="user.userId"
        />
      </div>
      <div id="login-input">
        <label for="userPassword">비밀번호</label>
        <input
          type="password"
          class="form-check-input"
          id="userPassword"
          v-model.trim="user.userPassword"
        />
      </div>
    </div>
    <button id="login-btn" @click="login">로그인</button>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useUserStore } from "@/stores/user.js";

const store = useUserStore();

const user = ref({
  userId: "",
  userPassword: "",
});

onMounted(() => {
  store.loginErr = false;
  store.activeLoginErrClass = "";
});

const login = function () {
  if (user.value.userId !== null && user.value.userPassword !== null) {
    store.login(user.value);
  }
};
</script>

<style scoped>
#container {
  width: 400px;
  height: 600px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding-top: 20px;
  padding-bottom: 20px;
  margin: auto;
}

#field-name {
  font-size: 25px;
  text-align: center;
}

#login-form {
  height: 110px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 5px 0;
  margin-bottom: 40px;
}

#login-input {
  width: 300px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  font-size: 15px;
}

.form-check-input {
  height: 35px;
  width: 200px;
  border-radius: 5px;
}

input {
  height: 35px;
  width: 200px;
  border-radius: 5px;
}

#login-btn {
  width: 200px;
  height: 40px;
  border-style: none;
  font-size: 16px;
  border-radius: 5px;
  background-color: #ffdb5c;
}

hr {
  width: 300px;
}

.alert {
  width: 300px;
  height: 50px;
  margin: 0;
}

#alert-msg {
  font-size: 13px;
}
</style>
