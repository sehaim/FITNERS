<template>
  <div id="club-signup-container">
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
  background-color: skyblue;
  display: flex;
  flex-direction: column;
  padding: 5%;
  align-items: center;

}

#content {
  font-size: 20px;
  position: relative;
  top: 40%;
}

button {
  position: relative;
  top: 70%;
}


</style>