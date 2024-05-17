<template>
  <div>
    <div>클럽 회원만 볼 수 있습니다.</div>
    <button @click="signupClub">가입하기</button>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";

const store = useClubStore()

defineProps({
  clubId: Number,
});


const signupClub = function () {
  store.signupClub()
}

</script>