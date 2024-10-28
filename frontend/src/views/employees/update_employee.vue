<script setup>
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";

import { updateEmployee, getOneEmployee } from "../../api/employees";
import EmployeeForm from "../../components/employee_form.vue";

const route = useRoute();
const router = useRouter();

const initialData = ref(null);

onMounted(async () => {
  initialData.value = await getOneEmployee(route.params.id);
});

const handleSubmit = async (data) => {
  await updateEmployee({
    ...initialData.value,
    ...data,
  });

  router.push({ name: "all_employees" });
};
</script>

<template>
  <main class="container">
    <h3>Обновление</h3>
    <EmployeeForm v-if="initialData" :initial-data="initialData" @submit="handleSubmit" button-text="Обновить" />
  </main>
</template>
