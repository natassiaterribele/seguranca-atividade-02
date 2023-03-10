import { useForgotPasswordInputs } from '../../../hook/index';
import { Button, FormContainer, TextInput } from '../../components/index';

export function ForgotPasswordScreen() {
  const { formInputs, handleChange, handleSubmit } = useForgotPasswordInputs();

  return (
    <form onSubmit={handleSubmit}>
      <FormContainer>
        <TextInput
          placeholder="seunome@email.com"
          labelText="Email"
          inputName="email"
          inputValue={formInputs.email}
          onChange={handleChange}
        />
        <div className="adjust-button">
          <Button>Enviar</Button>
        </div>
      </FormContainer>
    </form>
  );
}
