import Card from "../UI/Card";
import ExpenseDate from "./ExpenseDate";
import "./ExpenseItem.css";
function ExpenseItem({ expense }) {
  return (
    <li>
      <Card className="expense-item">
        <ExpenseDate date={expense.date} />
        <div className="expense-item__description">
          <h2>{expense.title}</h2>
          <div className="expense-item__price">${expense.amount}</div>
          {/* <button onClick={() => setTitle("Updated")}> Update</button> */}
        </div>
      </Card>
    </li>
  );
}

export default ExpenseItem;
