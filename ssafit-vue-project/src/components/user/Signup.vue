<template>
  <div id="container">
    <div id="field-name">
      <div>회원가입</div>
      <hr />
    </div>
    <div id="signup-form">
      <div id="signup-input">
        <label for="userId">아이디</label>
        <input
          type="text"
          id="userId"
          class="form-check-input"
          v-model="user.userId"
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
          required
        />
      </div>
      <div id="signup-input">
        <label for="userPassword">비밀번호</label>
        <input
          type="text"
          id="userPassword"
          class="form-check-input"
          v-model="user.userPassword"
          placeholder=" 8~20자 (영문, 숫자, 특수문자)"
          required
        />
      </div>
      <!-- <div id="signup-input">
        <label for="passwordCheck">비밀번호 확인</label>
        <input type="text" id="passwordCheck" class="form-check-input" v-model="user.passwordCheck" required>
      </div> -->
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
    <button id="signup-btn" @click="signup">가입</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user.js";

const store = useUserStore();

const user = ref({
  userId: "",
  userName: "",
  userPassword: "",
  isManager: "false",
});

const signup = function () {
  store.signup(user.value);
};
</script>

<style scoped>
#container {
  width: 400px;
  height: 500px;
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

#signup-form {
  height: 250px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 20px 0;
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
  width: 180px;
  height: 35px;
}

#signup-btn {
  width: 200px;
  height: 40px;
  border-style: none;
  font-size: 16px;
  border-radius: 5px;
  background-color: #ffdb5c;
}

.form-check-input,
.form-select {
  height: 35px;
  width: 200px;
  border-radius: 5px;
}

hr {
  width: 300px;
}
</style>
