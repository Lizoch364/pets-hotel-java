<script setup>
import { onMounted, ref } from "vue";
import { deleteEmployee, getAllEmployees } from "../../api/employees";

const employees = ref([]);

onMounted(async () => {
  await fetchData();
});

const fetchData = async () => {
  employees.value = (await getAllEmployees()) ?? [];
};

const handleDeleteEmployee = async (id) => {
  await deleteEmployee(id);
  await fetchData();
};
</script>

<template>
  <main class="container overflow-x-scroll">
    <div class="d-flex justify-content-between align-items-center w-100">
      <h2 class="h2">Работники</h2>
      <div>
        <RouterLink :to="{ name: 'create_employee' }" class="btn btn-primary btn-sm"> Создать </RouterLink>
      </div>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Имя</th>
          <th scope="col">Фамилия</th>
          <th scope="col">Отчество</th>
          <th scope="col">Должность</th>
          <th scope="col">Номер телефона</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="employee in employees" :key="employee.id">
          <th scope="row">{{ employee.id }}</th>
          <td>{{ employee.name }}</td>
          <td>{{ employee.surname }}</td>
          <td>{{ employee.middle_name }}</td>
          <td>{{ employee.post }}</td>
          <td>{{ employee.phone_number }}</td>
          <td>
            <div class="d-flex gap-1">
              <RouterLink
                class="btn btn-secondary btn-sm"
                :to="{ name: 'update_employee', params: { id: employee.id } }"
              >
                Обновить
              </RouterLink>
              <button class="btn btn-outline-danger btn-sm" @click="handleDeleteEmployee(employee.id)">Удалить</button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>
