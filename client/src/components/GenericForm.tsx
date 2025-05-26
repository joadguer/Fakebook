import { Button } from "react-bootstrap";
import { useForm } from "react-hook-form";
import "../styles/form.css";

export interface GenericFormProps {
    onSubmit?: () => void;
    children?: React.ReactNode;
    submitText?: string;
    buttonProps?: React.ComponentProps<typeof Button>;
}

export const GenericForm = (props: GenericFormProps) => {
    const { handleSubmit } = useForm();

    return (
        <form onSubmit={handleSubmit(props.onSubmit?? (() => {}))} className="generic-form">
            {props.children}
            <Button
                type="submit"
                {...props.buttonProps}
                className="submit-button">
                {props.submitText ?? "Submit"}
            </Button>
        </form>
    )
}