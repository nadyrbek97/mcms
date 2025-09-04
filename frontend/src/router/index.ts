import { createRouter, createWebHistory } from "vue-router";
import DepartmentList from "../components/department/DepartmentList.vue";
import ServiceList from "../components/service/ServiceList.vue";

const routes = [
  { path: "/", redirect: "/departments" },
  { path: "/departments", name: "departments", component: DepartmentList },
  {
    path: "/departments/services/:id",
    name: "services",
    component: ServiceList,
    props: true,
  },
];

export default createRouter({
  history: createWebHistory(),
  routes,
});
