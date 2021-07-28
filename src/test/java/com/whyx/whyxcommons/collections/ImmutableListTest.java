package com.whyx.whyxcommons.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sam Wykes.
 * Class used to test the {@link ImmutableList} class.
 */
@ExtendWith(MockitoExtension.class)
public class ImmutableListTest {

    @Test
    void getTest(@Mock final Object object) {

        // set up the immutable list.
        List<Object> mutableList = new ArrayList<>();
        mutableList.add(object);
        ImmutableList<Object> immutableList = new ImmutableList<>(mutableList);

        assertThat(immutableList.get(0)).isSameAs(object);

    }

}
