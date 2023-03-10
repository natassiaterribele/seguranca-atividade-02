import { axiosInstance } from '../_base/axiosInstance';

const URL_USER_REGISTER = '/usuarios';

export async function register({ username, password, phone, mail, imageUrl }) {
  const response = await axiosInstance.post(URL_USER_REGISTER, {
    nome: username,
    senha: password,
    telefone: phone,
    email: mail,
    fotoUrl: imageUrl,
  });
  return response.data;
}
