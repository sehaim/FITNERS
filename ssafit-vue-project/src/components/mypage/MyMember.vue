<template>
  <div id="my-member-container">
    <div id="my-member-container-header">
      <div id="title">
        <img src="@/assets/img/mymember-icon.png" alt="myschedule-icon" />
        <div>My Member</div>
      </div>
    </div>
    <MyMemberList :loginUser="loginUser" />
  </div>
</template>

<script setup>
import MyMemberList from "./MyMemberList.vue";

defineProps({
  loginUser: Object,
});
</script>

<style scoped>
#my-member-container {
  height: 100%;
  min-height: 100%;
  width: 50%;
  min-width: 50%;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

#my-member-container-header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 15px;
}

#title {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 22px;
}

img {
  width: 40px;
  margin-right: 20px;
  opacity: 60%;
}

hr {
  width: 90%;
}
</style>
