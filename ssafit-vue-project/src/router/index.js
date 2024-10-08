import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import BoardView from "@/views/BoardView.vue";
import ClubView from "@/views/ClubView.vue";
import MyPageView from "@/views/MyPageView.vue";
import LoginView from "@/views/LoginView.vue";
import SignupView from "@/views/SignupView.vue";
import NotFoundView from "@/views/NotFoundView.vue";
import ClubList from "@/components/club/ClubList.vue";
import ClubDetail from "@/components/club/ClubDetail.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardCreate from "@/components/board/BoardCreate.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
      children: [
        {
          path: '',
          name: 'boardList',
          component: BoardList
        },
        {
          path: 'create',
          name: 'boardCreate',
          component: BoardCreate,
          props: route => ({ userId: route.query.userId })
        },
        {
          path: 'update',
          name: 'boardUpdate',
          component: BoardUpdate,
          props: route => ({
            boardId: route.query.boardId,
            title: route.query.title, 
            content: route.query.content,
            userId: route.query.userId,
            writeTime: route.query.writeTime
          })
        },
        {
          path: ':id',
          name: 'boardDetail',
          component: BoardDetail
        },
      ]
    },
    {
      path: "/club",
      name: "club",
      component: ClubView,
      children: [
        {
          path: "",
          name: "clubList",
          component: ClubList,
        },
        {
          path: ":clubId",
          name: "clubDetail",
          component: ClubDetail,
        },
      ],
    },
    {
      path: "/mypage",
      name: "mypage",
      component: MyPageView,
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: "/signup",
      name: "signup",
      component: SignupView,
    },
    {
      path: "/notFound",
      name: "notFound",
      component: NotFoundView,
    },
  ],
});

export default router;
