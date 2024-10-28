<script setup>
import { useRouter } from "vue-router";

import { createEmployee } from "../../api/employees";
import EmployeeForm from "../../components/employee_form.vue";

const router = useRouter();

const handleSubmit = async (data) => {
  await createEmployee({
    ...data,
  });

  router.push({ name: "all_employees" });
};
</script>

<template>
  <main class="container">
    <h3>Создание</h3>
    <EmployeeForm @submit="handleSubmit" button-text="Создать" />
  </main>
</template>
