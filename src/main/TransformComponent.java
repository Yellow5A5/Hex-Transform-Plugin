package main;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Yellow5A5 on 16/9/28.
 */
public class TransformComponent implements ApplicationComponent, PersistentStateComponent<TransformComponent>{
    @Override
    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
        TransformAction action = new TransformAction();
        am.registerAction("TransformAction", action);
        DefaultActionGroup windowM = (DefaultActionGroup) am.getAction("WindowMenu");
        windowM.addSeparator();
        windowM.add(action);
    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "TransformComponent";
    }

    @Nullable
    @Override
    public TransformComponent getState() {
        return this;
    }

    @Override
    public void loadState(TransformComponent state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
