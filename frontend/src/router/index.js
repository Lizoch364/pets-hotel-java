import { createRouter, createWebHistory } from "vue-router";

import HomeView from "../views/home_view.vue";
import OwnersView from "../views/owners/all_owners.vue";
import OwnersCreateView from "../views/owners/create_owner.vue";
import OwnersUpdateView from "../views/owners/update_owner.vue";
import EmployeesView from "../views/employees/all_employees.vue";
import EmployeesCreateView from "../views/employees/create_employee.vue";
import EmployeesUpdateView from "../views/employees/update_employee.vue";
import SpeciesView from "../views/species/all_species.vue";
import TypeFeedView from "../views/typefeed/all_typefeed.vue";
import FeedsView from "../views/feed/all_feeds.vue";
import FeedsCreateView from "../views/feed/create_feed.vue";
import FeedsUpdateView from "../views/feed/update_feed.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/owners",
      name: "all_owners",
      component: OwnersView,
    },
    {
      path: "/owners/create",
      name: "create_owner",
      component: OwnersCreateView,
    },
    {
      path: "/owners/update/:id",
      name: "update_owner",
      component: OwnersUpdateView,
    },
    {
      path: "/employees",
      name: "all_employees",
      component: EmployeesView,
    },
    {
      path: "/employees/new",
      name: "create_employee",
      component: EmployeesCreateView,
    },
    {
      path: "/employees/update/:id",
      name: "update_employee",
      component: EmployeesUpdateView,
    },
    {
      path: "/species",
      name: "all_species",
      component: SpeciesView,
    },
    {
      path: "/type-feed",
      name: "all_typefeed",
      component: TypeFeedView,
    },
    {
      path: "/feeds",
      name: "all_feeds",
      component: FeedsView,
    },
    {
      path: "/feeds/create",
      name: "create_feed",
      component: FeedsCreateView,
    },
    {
      path: "/feeds/update/:id",
      name: "update_feed",
      component: FeedsUpdateView,
    },
  ],
});

export default router;
