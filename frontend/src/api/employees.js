import { http } from "./axios";

const BASE_URL = "/api/v1/hotels/employees";

export const getAllEmployees = async () => {
  const data = await http.get(BASE_URL);
  return data.data;
};

export const getOneEmployee = async (id) => {
  const data = await http.get(`${BASE_URL}/${id}`);
  return data.data;
};

export const createEmployee = async (data) => {
  const response = await http.post(`${BASE_URL}`, {
    ...data,
  });

  console.log(response);
  return response.data;
};

export const updateEmployee = async (data) => {
  const response = await http.put(`${BASE_URL}`, {
    ...data,
  });

  console.log(response);
  return response.data;
};

export const deleteEmployee = async (id) => {
  const response = await http.delete(`${BASE_URL}/${id}`);
  console.log(response);
  return response.data;
};
