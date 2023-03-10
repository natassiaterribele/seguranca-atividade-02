import './textInput.style.css';
export function TextInput({
  labelText,
  inputName,
  inputValue,
  onChange,
  placeholder,
}) {
  return (
    <>
      <label htmlFor="textInput">{labelText}</label>
      <input
        type="text"
        placeholder={placeholder}
        className="input-text"
        id="textInput"
        name={inputName}
        autoComplete="off"
        value={inputValue}
        onChange={onChange}
      />
    </>
  );
}
