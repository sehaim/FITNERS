<template>
  <div id="myclub-container">
    <div id="myclub-container-header">
      <div id="title">
        <img src="@/assets/img/myclub-icon.png" alt="myclub-icon" />
        <div>My Club</div>
      </div>
    </div>
    <MyClubList />
  </div>
</template>

<script setup>
import MyClubList from "@/components/mypage/MyClubList.vue";
</script>

<style scoped>
#myclub-container {
  height: 100%;
  min-height: 100%;
  width: 50vw;
  min-width: 50vw;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

#myclub-container-header {
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
}
</style>
