import ExpenseItem from "./ExpenseItem";
import "./ExpensesList.css";
export default function ExpensesList(props) {
  if (props.filteredExpenses.length === 0) return <h2 className="expenses-list__fallback ">Found no expenses</h2>;
  return (
    <ul className="expenses-list">
      {props.filteredExpenses.map((ex) => (
        <ExpenseItem key={ex.id} expense={ex} />
      ))}
    </ul>
  );
}
