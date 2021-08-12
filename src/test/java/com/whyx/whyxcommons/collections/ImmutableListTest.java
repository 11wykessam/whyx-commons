package com.whyx.whyxcommons.collections;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

/**
 * @author Sam Wykes.
 * Class used to test the {@link ImmutableList} class.
 */
@ExtendWith(MockitoExtension.class)
public class ImmutableListTest {

    @Nested
    public class PreconditionTest {

        @Test
        public void ofNotNullTest() {
            assertThatNullPointerException()
                    .isThrownBy(() -> ImmutableList.ofList(null))
                    .withMessage("list must not be null");
        }

        @Test
        public void containsItemNotNullTest(@Mock final List<Object> list) {
            final ImmutableList<Object> immutableList = ImmutableList.ofList(list);
            assertThatNullPointerException()
                    .isThrownBy(() -> immutableList.contains(null))
                    .withMessage("object must not be null");
        }

        @Test
        public void equalsItemNotNullTest(@Mock final List<Object> list) {
            final ImmutableList<Object> immutableList = ImmutableList.ofList(list);
            assertThatNullPointerException()
                    .isThrownBy(() -> immutableList.equals(null))
                    .withMessage("object must not be null");
        }

    }

    @Nested
    public class BuildTest {

        @Mock
        private Object objectOne;

        @Mock
        private Object objectTwo;

        @Mock
        private Object objectThree;

        @Test
        public void sizeNonEmptyTest() {
            final List<Object> mutableList = new ArrayList<>();
            mutableList.add(objectOne);
            mutableList.add(objectTwo);
            mutableList.add(objectThree);

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.size()).isEqualTo(mutableList.size());
        }

        @Test
        public void sizeEmptyTest() {
            final List<Object> mutableList = new ArrayList<>();

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.size()).isEqualTo(mutableList.size());
        }

        @Test
        public void isEmptyReturnsFalseWhenNonEmptyTest() {
            final List<Object> mutableList = new ArrayList<>();
            mutableList.add(objectOne);
            mutableList.add(objectTwo);
            mutableList.add(objectThree);

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.isEmpty()).isFalse();
        }

        @Test
        public void isEmptyReturnsTrueWhenEmptyTest() {
            final List<Object> mutableList = new ArrayList<>();

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.isEmpty()).isTrue();
        }

        @Test
        public void containsReturnsTrueTest() {
            final List<Object> mutableList = new ArrayList<>();
            mutableList.add(objectOne);

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.contains(objectOne)).isTrue();
        }

        @Test
        public void containsReturnsFalseWhenEmptyTest() {
            final List<Object> mutableList = new ArrayList<>();

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.contains(objectOne)).isFalse();
        }

        @Test
        public void containsReturnsFalseWhenNonEmptyTest() {
            final List<Object> mutableList = new ArrayList<>();
            mutableList.add(objectTwo);

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.contains(objectOne)).isFalse();
        }

        @Test
        public void equalsReturnsTrueWhenEqualNonEmptyTest() {
            final List<Object> mutableListOne = new ArrayList<>();
            mutableListOne.add(objectOne);
            mutableListOne.add(objectTwo);
            mutableListOne.add(objectThree);

            final List<Object> mutableListTwo = new ArrayList<>();
            mutableListTwo.add(objectOne);
            mutableListTwo.add(objectTwo);
            mutableListTwo.add(objectThree);

            final ImmutableList<Object> immutableListOne = ImmutableList.ofList(mutableListOne);
            final ImmutableList<Object> immutableListTwo = ImmutableList.ofList(mutableListTwo);

            assertThat(immutableListOne.equals(immutableListTwo)).isTrue();
        }

        @Test
        public void equalsReturnsTrueWhenEqualEmptyTest() {
            final List<Object> mutableListOne = new ArrayList<>();
            final List<Object> mutableListTwo = new ArrayList<>();

            final ImmutableList<Object> immutableListOne = ImmutableList.ofList(mutableListOne);
            final ImmutableList<Object> immutableListTwo = ImmutableList.ofList(mutableListTwo);

            assertThat(immutableListOne.equals(immutableListTwo)).isTrue();
        }

        @Test
        public void equalsReturnsFalseWhenNotEqualTest(
                @Mock final List<Object> mutableListOne,
                @Mock final List<Object> mutableListTwo
        ) {
            final ImmutableList<Object> immutableListOne = ImmutableList.ofList(mutableListOne);
            final ImmutableList<Object> immutableListTwo = ImmutableList.ofList(mutableListTwo);

            assertThat(immutableListOne.equals(immutableListTwo)).isFalse();
        }

        @Test
        public void getTest() {
            final List<Object> mutableList = new ArrayList<>();
            mutableList.add(objectOne);
            mutableList.add(objectTwo);
            mutableList.add(objectThree);

            final ImmutableList<Object> immutableList = ImmutableList.ofList(mutableList);

            assertThat(immutableList.get(0)).isSameAs(objectOne);
            assertThat(immutableList.get(1)).isSameAs(objectTwo);
            assertThat(immutableList.get(2)).isSameAs(objectThree);
        }

    }

}
