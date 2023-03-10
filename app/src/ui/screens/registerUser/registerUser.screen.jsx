import { useRegisterUser } from '../../../hook';
import {
  Button,
  FormContainer,
  LinkButton,
  PasswordInput,
  TextInput,
} from '../../components/index';

export function RegisterUserScreen() {
  const { registerInputs, handleChange, handleSubmit } = useRegisterUser();

  return (
    <FormContainer>
      <TextInput
        labelText="Nome:"
        inputName="username"
        inputValue={registerInputs.username}
        onChange={handleChange}
      />
      <TextInput
        placeholder="seunome@email.com"
        labelText="Email:"
        inputName="mail"
        inputValue={registerInputs.mail}
        onChange={handleChange}
      />
      <PasswordInput
        labelText="Senha:"
        inputName="password"
        forPassword="password"
        inputValue={registerInputs.password}
        onChange={handleChange}
      />
      <TextInput
        labelText="Telefone:"
        inputName="phone"
        inputValue={registerInputs.phone}
        onChange={handleChange}
      />
      <TextInput
        labelText="Foto URL:"
        inputName="imageUrl"
        inputValue={registerInputs.imageUrl}
        onChange={handleChange}
      />
      <div className="adjust-button">
        <Button onClick={handleSubmit}>Cadastrar-se</Button>
      </div>
      <LinkButton
        linkButtonName="Já possui uma Conta? Faça seu Login"
        link="/"
      />
    </FormContainer>
  );
}
