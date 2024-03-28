package com.helder.mysoothe

class MockDataSource {

    companion object {

        private val bodyAlignmentList: List<DataResource> = listOf(
            DataResource(
                imageResource = R.drawable.ab1_inversions,
                text = R.string.inversions
            ),
            DataResource(
                imageResource = R.drawable.ab2_quick_yoga,
                text = R.string.quick_yoga
            ),
            DataResource(
                imageResource = R.drawable.ab3_stretching,
                text = R.string.stretching
            ),
            DataResource(
                imageResource = R.drawable.ab4_tabata,
                text = R.string.tabata
            ),
            DataResource(
                imageResource = R.drawable.ab5_hiit,
                text = R.string.hiit
            ),
            DataResource(
                imageResource = R.drawable.ab6_pre_natal_yoga,
                text = R.string.pre_natal_yoga
            )
        )

        private val exerciseList: List<DataResource> = listOf(
            DataResource(
                imageResource = R.drawable.fc1_short_mantras,
                text = R.string.short_mantras
            ),
            DataResource(
                imageResource = R.drawable.fc2_nature_meditations,
                text = R.string.nature_meditations
            ),
            DataResource(
                imageResource = R.drawable.fc3_stress_and_anxiety,
                text = R.string.stress_and_anxiety
            ),
            DataResource(
                imageResource = R.drawable.fc4_self_massage,
                text = R.string.self_and_massage
            ),
            DataResource(
                imageResource = R.drawable.fc5_overwhelmed,
                text = R.string.overwhelmed
            ),
            DataResource(
                imageResource = R.drawable.fc6_nightly_wind_down,
                text = R.string.nightly_wind_down
            )
        )

        fun getBodyAlignmentList(): List<DataResource> {
            return bodyAlignmentList
        }

        fun getExerciseList(): List<DataResource> {
            return exerciseList
        }

    }
}