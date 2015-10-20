自定义一个**位于底部、占满屏幕**的`DiaglogFragment`，包含一个date picker，一个取消按钮，一个确定按钮。
Custom a DialogFragment that contains a date picker, the width is same as parent, and at bottom of the screen.

![BottomDiaglogFragment](https://github.com/li2/DatePickerDialogFragment/blob/master/BottomDiaglogFragment.png)


## 用法 Usage

Show the dialog in your activity:
```java
        mDatePickerDialog = new DatePickerDialog();
        mDatePickerDialog.setSelectedDate(new Date());
        mDatePickerDialog.show(getSupportFragmentManager(), "date");
        mDatePickerDialog.setOnDatePickerClickListener(new OnDatePickerClickListener() {
            @Override
            public void onCancelClick() {
                Toast.makeText(MainActivity.this, "cancel clicked", Toast.LENGTH_SHORT).show();
                mDatePickerDialog.dismiss();
            }
            
            @Override
            public void onAcceptClick(Date date) {
                Toast.makeText(MainActivity.this, "Accetp clicked" + date, Toast.LENGTH_SHORT).show();;
                mDatePickerDialog.dismiss();
            }
        });
```


## Custom a DialogFragment which the width is same as parent and at bottom of screen

```java
public class DatePickerDialog extends DialogFragment {
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    // 使用不带theme的构造器，获得的dialog边框距离屏幕仍有几毫米的缝隙。
    // Dialog dialog = new Dialog(getActivity()); // still has a little space between dialog and screen.
    Dialog dialog = new Dialog(getActivity(), R.style.CustomDatePickerDialog);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
    dialog.setContentView(R.layout.dialog_datepicker);
    dialog.setCanceledOnTouchOutside(true);
    
    // 设置宽度为屏宽、靠近屏幕底部。
    // set width and gravity.
    Window window = dialog.getWindow();
    WindowManager.LayoutParams wlp = window.getAttributes();
    wlp.gravity = Gravity.BOTTOM;
    wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
    window.setAttributes(wlp);
 
    return dialog;
  }
```

```xml
<!-- res/values/styles.xml -->
    <style name="CustomDatePickerDialog" parent="@style/AppTheme">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:windowIsFloating">true</item>
    </style>
```

By weiyi.li, http://li2.me, http://segmentfault.com/u/li2,  SH,  2015-10-21
