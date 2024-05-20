<template>
  <div id="club-to-mypage-container">
    <button id="close-button" @click="$emit('closeEvent')">x</button>
    <div id="content">
      <img src="@/assets/img/add-check-icon.png" alt="" />
      <div>My Schedule에 추가되었습니다.</div>
    </div>
    <RouterLink to="/mypage"
      ><button id="move-button" @click="$emit('closeEvent')">
        My Page 이동
      </button></RouterLink
    >
  </div>
</template>

<script setup></script>

<style scoped>
#club-to-mypage-container {
  width: 400px;
  height: 200px;
  display: flex;
  flex-direction: column;
  position: fixed;
  top: 40vh;
  left: 37vw;
  background-color: white;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 0.5px 2px 1px #cbcac8;
  border-radius: 5px;
  padding: 1%;
}

#close-button {
  font-size: 20px;
  background-color: transparent;
  border-style: none;
  color: rgb(139, 137, 137);
  margin-left: 90%;
}

img {
  width: 25px;
  margin-right: 10px;
}

#content {
  display: flex;
  flex-direction: row;
  align-items: center;
  color: rgb(71, 69, 69);
}

#move-button {
  width: 100px;
  min-width: 100px;
  height: 30px;
  min-height: 30px;
  border-style: none;
  border-radius: 5px;
  margin-bottom: 10px;
  background-color: #ffdc5cc3;
  color: rgb(71, 69, 69);
  font-size: 14px;
}
</style>
