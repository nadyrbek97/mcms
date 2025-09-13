import { createRouter, createWebHistory } from "vue-router";
import DepartmentList from "../components/department/DepartmentList.vue";
import ServiceList from "../components/service/ServiceList.vue";
import PageNotFound from "@/pages/PageNotFound.vue";
import Login from "@/components/Login.vue";
import store from "@/store";

const routes = [
  { path: "/", redirect: "/departments" },
  { path: "/login", component: Login },
  {
    path: "/departments",
    name: "departments",
    component: DepartmentList,
    meta: { requiresAuth: true },
  },
  {
    path: "/departments/services/:id",
    name: "services",
    component: ServiceList,
    props: true,
    meta: { requiresAuth: true },
  },
  {
    path: "/:notFound(.*)",
    component: PageNotFound,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, _, next) => {
  if (to.meta.requiresAuth && !store.getters.isAuthenticated) {
    next("/login");
  } else {
    next();
  }
});

export default router;
