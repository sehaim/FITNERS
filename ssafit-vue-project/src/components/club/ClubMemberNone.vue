<template>
  <div id="club-signup-container">
    <img src="@/assets/img/sad-icon.png" alt="sad-icon">
    <div id="content">클럽 회원만 볼 수 있습니다.</div>
    <button @click="signupClub">가입하기</button>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";

const store = useClubStore()

const props = defineProps({
  clubId: Number,
});


const signupClub = function () {
  store.signupClub(props.clubId)
}

</script>

<style scoped>
#club-signup-container {
  width: 400px;
  height: 350px;
  padding: 5%;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 10px;
  box-shadow: 0px 0px 3px 1px #8d8c8a;
  margin-top: 3%;
}

img {
  width: 50px;
  opacity: 70%;
  margin-top: 10px;
}


#content {
  font-size: 18px;
  position: relative;
  top: 20%;
}

button {
  position: relative;
  top: 50%;
  border-style: none;
  border-radius: 5px;
  width: 200px;
  height: 40px;
  font-size: 15px;
}


</style>